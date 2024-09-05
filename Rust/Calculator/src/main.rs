use std::io;

fn main() {
    println!("Calculator:");
    println!("Options:");
    let multiline_string = r#"
    1. Addition
    2. Subtraction
    3. Multiplication
    4. Division
    5. Remainder
        "#;
    println!("{}", multiline_string);

    println!("Enter an option: ");
    let mut stdopt = String::new();
    io::stdin()
        .read_line(&mut stdopt)
        .expect("Failed to read line");
    let opt: i64 = stdopt.trim().parse().expect("Input not an integer.");//Changes string to integer.

    println!("Enter Number: ");
    let mut numinp = String::new();
    io::stdin()
        .read_line(&mut numinp)
        .expect("Failed to read line");
    let num: i64 = numinp.trim().parse().expect("Input not an integer.");

    println!("Enter second number");
    let mut num1inp = String::new();
    io::stdin()
        .read_line(&mut num1inp)
        .expect("Failed to read Line");
    let num1: i64 = num1inp.trim().parse().expect("Input not an integer.");

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

//Modules for each action.
fn addition(num: i64, num1: i64) {
    let sum = num + num1;
    println!("Sum = {}", sum);
}

fn subtraction(num: i64, num1: i64) {
    let sub = num - num1;
    println!("Difference = {}", sub);
}

fn multiplication(num: i64, num1: i64) {
    let prod = num * num1;
    println!("Product = {}", prod);
}

fn division(num: i64, num1: i64) {
    let div = num / num1;
    println!("Answer = {}", div);
}

fn remainder(num: i64, num1: i64) {
    let rem = num % num1;
    println!("Remainder: {}", rem);
}
