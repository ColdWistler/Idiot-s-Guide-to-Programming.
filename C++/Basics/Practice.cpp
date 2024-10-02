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

  while (num != 0){
    count = num % 10
    reversed_num = reversed_num * 10 + count;
    num = num / 10;
  }
  cout << "Reverse = " << reversed_num;
 
}

int max(){
  int num1;
  int num2;
  int num3;

  cout << "Input First Number: ";
  cin >> num1;
  cout << "";
  cin >> num2;
  cout << "";
  cin >> num3;
}

int main(){
  evenodd();
  primecomposite();
  factorial();
  reverse();
}
