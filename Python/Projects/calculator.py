print("                  :Calculator:                     ")
print("===================================================")
print("""
1.Addition  
2.Subtraction  
3.Multiplication  
4.Division   
5.Remainder  
""")

option = input("Enter Option: ")
option = int(option) #Converting option into an integer to match with the if statements.


def addition():
    num = input("Enter Number: ")
    num1 = input("Enter Second Number: ")
    sum = num + num1
    print("Sum = ",sum)

def subtraction():
    num = input("Enter Number: ")
    num1 = input("Enter Second Number: ")
    sub = num - num1
    print("Subtraction = ",sub)

def multiplication():
    num = input("Enter Number: ")
    num1 = input("Enter Second Number: ")
    prod = num * num1
    print("Product = ",prod)

def remainder():
    num = input("Enter Number: ")
    num1 = input("Enter Second Number: ")
    rem = num % num1
    print("Remainder = ",rem)

def division():
    num = input("Enter Number: ")
    num1 = input("Enter Second Number: ")
    div = num/num1
    print("Division = ",div)


if option == 1:
    addition()
elif option == 2:
    subtraction()
elif option == 3:
    multiplication()
elif option == 4:
    division()
elif  option == 5:
    remainder()


print("===================================================")

