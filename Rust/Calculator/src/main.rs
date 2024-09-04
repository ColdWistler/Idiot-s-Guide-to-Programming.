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
    let num: i32 = stdopt.trim().parse().expect("Input not an integer.");

    println!("Enter second number");
    io::stdin()
        .read_line(&mut stdopt)
        .expect("Failed to read Line");
    let num1: i32 = stdopt.trim().parse().expect("Input not an integer.");

    if opt == 1 {
        addition(num, num1);
    } else if opt == 2 {
        subtraction(num, num1);
    } else if opt == 3 {
        multiplication(num, num1);
    } else if opt == 4 {
        division(num, num1);
    } else if opt == 5 {
        remainder(num, num1);
    } else {
        print!("Invalid Option:");
    }
}

fn addition(num: i32, num1: i32) {
    let sum = num + num1;
    println!("Sum = {}", sum);
}

fn subtraction(num: i32, num1: i32) {
    let sub = num - num1;
    println!("Difference = {}", sub);
}

fn multiplication(num: i32, num1: i32) {
    let prod = num * num1;
    println!("Product = {}", prod);
}

fn division(num: i32, num1: i32) {
    let div = num / num1;
    println!("Answer = {}", div);
}

fn remainder(num: i32, num1: i32) {
    let rem = num % num1;
    println!("Remainder: {}", rem);
}
