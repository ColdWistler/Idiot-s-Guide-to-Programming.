use std::io;

fn main() {
    println!("Calculator:");

    println!("Enter an option: ");
    let mut stdopt = String::new();
    io::stdin()
        .read_line(&mut stdopt)
        .expect("Failed to read line");
    let opt: i64 = stdopt.trim().parse().expect("Input not an integer.");

    println!("Enter Number: ");
    io::stdin()
        .read_line(&mut stdopt)
        .expect("Failed to read line");
    let num: i64 = stdopt.trim().parse().expect("Input not an integer.");

    println!("Enter second number");
    io::stdin()
        .read_line(&mut stdopt)
        .expect("Failed to read Line");
    let num1: i64 = stdopt.trim().parse().expect("Input not an integer.");

    if opt == 0 {
        addition(num, num1);
    } else if opt == 1 {
        subtraction(num, num1);
    } else if opt == 2 {
        multiplication(num, num1);
    } else if opt == 3 {
        division(num, num1);
    } else if opt == 4 {
        remainder(num, num1);
    } else {
        print!("Invalid Option:");
    }
}

fn addition(num: i64, num1: i64) {
    let sum = num + num1;
    println!("Sum = {}", sum);
}

fn subtraction() {
    let x = 20;
    let y = 30;

    let sub = x - y;
    println!("Difference = {}", sub);
}

fn multiplication() {
    let x = 10;
    let y = 20;

    let prod = x * y;
    println!("Product = {}", prod);
}

fn division() {
    let x = 20;
    let y = 10;

    let div = x / y;
    println!("Answer = {}", div);
}

fn remainder() {
    let x = 20;
    let y = 15;

    let rem = x % y;
    println!("Remainder: {}", rem);
}
