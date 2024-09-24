#include <iostream>

using namespace std;



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
    for(int i = 0; i <= num; i++){
      ans = num / i;
    }

    if(ans > 2){
      cout << "The number is composite";
    }else if(ans == 2){
      cout << "The number is Prime";
    }

  return 0;
}

int factorial() {
  int num;
  count << "Enter a number: ";
  cin >> num;
  
  int count = 1;
  for(int i;i<num;i++){
    ans = count * i;
  }
}

int reverse(){
  int num = 1234;
  int reversed_num = 0;
  int count;

  for(){}
}

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
