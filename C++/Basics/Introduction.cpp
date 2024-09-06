#include <iostream>
using namespace std;
//Functions:
//Hello World!.
void HelloWorld () {
    // cout is used to display output similar to print or println in other languages.
    cout << "Hello World!\n";// \n Outputs the next line in a new line.
    cout << "Hello Again." << endl; // endl can also be used to enter a new line.
}

//Variables and operators.
int Operators (int a, int b) {
  int r;
  r = a+b;
  cout << "Sum: " << r << endl;
  r = a - b;
  cout << "Subtraction: " << r << endl;
  r =  a*b;
  cout << "Product: " << r << endl;
  r = a/b;
  cout << "Division: " << r << endl;
  r=a%b;
  cout << "Remainder: " << r << endl;
  return 0;
}

//Basic Input Output System.
void input () {
    string name;
    cout << "Enter your name: ";
    getline (cin, name);
    cout << "Hello " << name << endl;
}
//Conditional Statements:
void conditions() {
    int x;
    cout << "Enter a Number: ";
    cin >> x;
    //If statements:
    if (x == 100)
        cout << "x is 100" << endl;
    else if (x == 200)
        cout << "x is 200" << endl;
    else
        cout << "x is " << x << endl;

    // {} can be used to write multiple statments inside an if statement.
    if (x < 100 && x > 10){
        cout << "x is smaller than 100" << endl;
        cout << "x is greater than 10" << endl;
    }
    cout << "Enter an option: 1/2/....";
    cin >> x;
    //Switch Case:
    switch (x) {
        case 1:
            cout << "x is 50" << endl;
        case 2:
            cout << "x is 69" << endl;
        default:
        cout << "x is not 50 or 69" << endl;
    }
}

//Iteration statements: (Loops)
void loops(){
    int n = 10;
    int i = 0;
    //While loops
    cout << "============While Loop Starts=========\n";
    while (i<=n) {
        cout << "While Loop: " << i << "\n";
        i++;
    }
    cout << "Value of i after while loop: " << i << "\n";
    //The value changes so has to be reset
    i = 0;
    //Do While Loops
    cout << "===========Do While Loop:=============\n";
    do{
        cout << "Do While Loop: " << i << "\n";
        i++;
    }while (i <= 10);

    //For Loops
    cout << "--------------For Loop:----------------\n";
    for(i=0;i<=n;i++){
        cout << "For Loop: " << i << endl;
    }

}

//Arrays:
void arrays(){
string arrays[3] = {"Hamster","Cat","Dog"};
}

// Program runs on the main function.
int main() {
    HelloWorld();
    Operators (5,3);
    input();
    conditions();
    loops();
    return 0;
}
// << is a right shift operator.
