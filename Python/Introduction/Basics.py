# Print statement:
print("Hello World")

# Functions.
#Operators:
def operators():
    x = 40
    y = 20
    sum = x + y
    subtraction = x - y
    product = x * y
    division = x / y
    remainder = x % y

    print("Sum: ",sum)
    print("Subtraction: ",subtraction)
    print("Product: ",product)
    print("Division: ",division)
    print("Remainder: ",remainder)

def conditions():
    #If Statements
    x = input("Enter a number")
    if x == 10:
        print("Number you entered is 10")
    elif x == 20:
        print("Number you entered is 20")
    else:
        print("The number you entered is ",x)

def loops():
    #For Loops
    for i in range(1,5):
        print("For Loop: ", i)

    i = 0

    #While Loops
    while i <= 10:
        print("While Loop: ", i)
        i = i + 1

def arrays():
    cars[]={"Ford","Ferarri","Lockheed Martin"}#Making an Array
    x = cars[2]#[] Is the position of the item in the array.
    #Note: Positions star with 0 hence 3 items position goes 0,1,2
    print(x)
    x = len(cars)#Shows the length.
    #Adding elements to the array.
    cars.append("Toyota")
    #To remove use pop
    cars.pop(1)
    #Remove can also be used
    cars.remove("Lockheed Martin")

#Output
conditions()
operators()
loops()
arrays()
