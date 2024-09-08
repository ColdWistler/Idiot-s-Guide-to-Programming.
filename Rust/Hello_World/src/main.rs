use std::io;

fn main() {
    let multiline_string = r#"
    This is a multiline 
        String Used to output multiple lines.
        "#;
    println!("Hello, world!");
    println!("{}",multiline_string);
    mutability();
    parameters(10, 20);
    controlstatements();
    loops();
    input();
}

// Mutability Mut syntax:
fn mutability() {
    //Mutable variables can change their values.
    let mut x = 5;
    println!("The value {x} is mutable:");
    x = 8;
    println!("The value {x} changed");
}

//Functions with parameters:
// i64 is the 64 bit data type.
fn parameters(x: i64, y: i64) {
    println!("The two numbers are {x} and {y}");
    let sum = x + y;
    println!("Sum = {sum}");
}

//If statements:
fn controlstatements() {
    // Conditional statements
    let option = true;
    if option == true {
        println!("Option is true:");
    } else if option == false {
        println!("Option is false:");
    } else {
        println!("Idk what the option is lol");
    }
}

//Loops
/*
    Vairables are immutable by default in rust.
    for a loop a variable is assigned a counter which makes it so that the variable
    has to change data multiple times.
    Thus turning the variable mutable is important.
*/

fn loops() {
    let mut i = 0;
    println!("While Loops: ");
    while i <= 10 {
        println!("{i} Loop.");
        i = i + 1;
    }
    println!("For Loops: ");
    for i in 1..10 {
        println!("{i} Loops. ");
    }
}

fn input(){
    println!("Enter a number: ");
    let mut inp = String::new();
    io::stdin()
        .read_line(&mut inp)
        .expect("Failed to read line");

    println!("You entered: {}", inp);
}

//Ownership:
fn Ownership(){
    let a = String::from("Hello");
    let a1 = a;

    println!("{a1}, World!");
}

fn Cloning(){
    let s1 = String::from("Hello_world!");
    
}

