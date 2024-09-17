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

int evenodd(){
  int number;
  cout << "Enter a number: ";
  cin >> number;

  if(){
    cout << "The number is even. ";
  }
  else {
    cout << "The number is odd.";
  };
  return 0;
}

int primecomposite() {
    int num;
    int ans;

    cout << "Enter a number: ";
    cin >> num;
}
