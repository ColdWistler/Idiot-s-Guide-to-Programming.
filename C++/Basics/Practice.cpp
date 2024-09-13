#include <iostream>

using namespace std;

int main(){
  int number;
  cout << "Enter a number";
  cin >> number;
  int factorial = 1;

  //factorial
  for(int i=1; i<=number; i++){
    factorial = i * factorial;
  }
  cout << factorial;
}
