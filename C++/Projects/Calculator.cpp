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


int main(){
    int opt;
    cout << "Enter Option: ";
    cin >> opt;
    if (opt == 1){
        addition();
    }else if (opt == 2) {
        subtraction();
    }
}
