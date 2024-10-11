#include <iostream>
using namespace std;

void addition(){
    int x;
    int y;
    cout << "Enter Number: ";
    cin >> x;
    cout << "Enter Second Number: ";
    cin >> y;
    int sum = x + y;
    cout << "Sum = " << sum << endl;
}

void subtraction(){
    int x;
    int y;
    cout << "Enter Number: ";
    cin >> x;
    cout << "Enter Second Number: ";
    cin >> y;
    int sub = x - y;
    cout << "Subtraction = " << sub << endl;
}

void multiplication(){
    int x;
    int y;
    cout << ""
    cout << "Enter Number: ";
    cin >> x;
    cout << "Enter Second Number: ";
    cin >> y;
    int prod = x * y;
    cout << "Product = " << prod << endl;
}

void division(){
    int x;
    int y;
    cout << "Enter Number: ";
    cin >> x;
    cout << "Enter Second Number: ";
    cin >> y;
    int div = x / y;
    cout << "Division = " << div << endl;
}

void remainder(){
    int x;
    int y;
    cout << "Enter Number: ";
    cin >> x;
    cout << "Enter Second Number: ";
    cin >> y;
    int rem = x % y;
    cout << "Remainder = " << rem << endl;
}

int main(){
    int opt;
    cout << "Enter Option: ";
    cin >> opt;
    if (opt == 1){
        addition();
    }else if (opt == 2) {
        subtraction();
    }else if (opt == 3){
        multiplication();
    }else if (opt == 4){
        division();
    }else if (opt == 5){
        remainder();
    }
}
