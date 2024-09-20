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



#Outputs
factorial()
evenodd()
primecomp()
