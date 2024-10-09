#Practice Questions:

#Factorial of a number
def factorial():
  x = input()
  factorial = 1
  for i in range(1,int(x)+1):
    factorial = 1 * factorial

  print(factorial)

def evenodd():
  x = input("Enter a number.")
  if x % 2 = 0:
    print("The number is even.")
  else 
    print("The number is odd.")

def primecomp():
  num = input("Enter a number: ")
  for i in range(1,int(num)+1):
    if num % i = 0:
      count = count + 1

  if count == 2:
    print("The number is prime.")
  else if count > 2:
    print("The number is composite.")

def reverse():
  num = 1234
  reversed_num = 0

  while num != 0:
    digit = num % 10
    reversed_num = reversed_num * 10 + digit
    num //= 10
    print("Reversed Number: " + str(reversed_num))

  def maximum():
    x = input("Enter First Number: ")
    y = input("Enter Second Number: ")
    z = input("Enter Third Number: ")

    if x > y: 
      if x > z:
        print("The largest number is: ",x)
      else
        print("The largest number is: ",z)
    else
      if y > z:
        print("The largest number is: ",y)
      else
        print("The largest number is: ",z)
  
#==
#Outputs
factorial()
evenodd()
primecomp()
