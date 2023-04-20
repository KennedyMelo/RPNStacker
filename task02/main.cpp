#include<bits/stdc++.h>
using namespace std;

bool isNumber(string s){
  for(auto u: s){
    if(!isdigit(u)) return false;
  }
  return true;
}
bool valid(string s){
  if(s=="+" || s=="-" || s=="*" || s=="/" || isNumber(s)) return true;
  return false;
}
int main(){
  string current;
  stack<long double>pilha;
  vector<string>tokens;
  long double a,b;
  while(cin>>current){
    if(isNumber(current)){
      pilha.push(stoi(current));
      tokens.push_back(string("[type=") + "NUM" + ", lexeme=" + current+ "]");
    } else{
      try{
        if(!valid(current)){
          throw (string)"Error: Unexpected character: " + current;
          return 0;
        } 
        else{
          b = pilha.top(); pilha.pop();
          a = pilha.top(); pilha.pop();
          if(current=="+"){
            pilha.push(a+b);
            tokens.push_back(string("[type=") + "PLUS" + ", lexeme=" + current+ "]");
          } else if(current=="-"){
            pilha.push(a-b);
            tokens.push_back(string("[type=") + "MINUS" + ", lexeme=" + current+ "]");
          } else if(current=="*"){
            pilha.push(a*b);
            tokens.push_back(string("[type=") + "STAR" + ", lexeme=" + current+ "]");
          } else if(current=="/"){ // divisao
            if(b==0){
              throw "Division by zero condition!";
              break;
            }
            tokens.push_back(string("[type=") + "SLASH" + ", lexeme=" + current+ "]");
            pilha.push(a/b);
          }  
        }
      } catch(const char* msg){
        cerr<<msg<<endl;
        return 0;
      } catch(string msg){
        cerr<<msg<<endl;
        return 0;
      }
      
    }
  }
  if(pilha.size() == 1){
    for(auto u: tokens){
      cout<<u<<endl;
    }
    cout<<endl<<"Saida: "<<pilha.top()<<endl;
  }
  return 0;
}