use std::io;

fn main() {
    factorial();
}

fn factorial() {
    println!("Enter a number:");
    let mut inp = String::new();
    io::stdin()
        .read_line(&mut inp)
        .expect("Failed to read line");
    let num: i64 = inp.trim().parse().expect("Input not an integer.");

    println!("Num = {}", num);
    //Fails here
    let i = 1;
    let mut factorial = 1;
    // Goes on an infinite loop
    while i <= num {
        factorial = factorial * i;
    }
    println!("Factorial: {}", factorial);
}
