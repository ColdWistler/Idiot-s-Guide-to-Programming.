use std::io;

fn main() {
    println!("Calculator:");

    println!("Enter an option: ");
    let mut stdopt = String::new();
    io::stdin()
        .read_line(&mut stdopt)
        .expect("Failed to read line");
    let opt: i64 = stdopt.trim().parse().expect("Input not an integer.");

    if opt == 1{
        addition();
    }else if opt == 2{
        subtraction();
    }else if opt == 3{
        multiplication();
    }else if opt == 4{
        division();
    }else if opt == 5{
        remainder();
    }else{
        print!("Invalid Option:");
    }
    let mut num = String::new();
    let mut num1 = String::new();
    println!("Enter Number: ");
} 

fn addition() {
   let x = 20;
   let y = 30;

   let sum = x + y;
   println!("Sum = {}",sum);
}

fn subtraction() {
    let x = 20;
    let y = 30;
    
    let sub = x - y;
    println!("Difference = {}",sub);
}

fn multiplication() {
    let x = 10;
    let y = 20;

    let prod = x * y;
    println!("Product = {}",prod);
}

fn division(){
    let x = 20;
    let y = 10;

    let div = x / y;
    println!("Answer = {}",div);
}

fn remainder(){
    let x = 20;
    let y = 15;

    let rem = x % y;
    println!("Remainder: {}",rem);
}
