#include<bits/stdc++.h>
using namespace std;

int main(){
  string current;
  stack<long double>pilha;
  long double a,b;
  while(cin>>current){
    if(isdigit(current[0])){
      pilha.push(stoi(current));
    } else{
      b = pilha.top(); pilha.pop();
      a = pilha.top(); pilha.pop();
      if(current[0]=='+'){
        pilha.push(a+b);
      } else if(current[0]=='-'){
        pilha.push(a-b);
      } else if(current[0]=='*'){
        pilha.push(a*b);
      } else{ // divisao
        if(b==0){
          cout<<"NAO EH PERMITIDO DIVISAO POR ZERO"<<endl;
          return 0;
        }
        pilha.push(a/b);
      }
    }
  }
  if(pilha.size() == 1){
    cout<<"O resultado da expressao eh: "<<pilha.top()<<endl;
  }
  return 0;
}