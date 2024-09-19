luse std::io;

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
    // Goes on an infinite loop Date: 14th september
    while i <= num {
        factorial = factorial * i;
    }
    println!("Factorial: {}", factorial);
}

fn primeodd() {
    println!("Enter a number:");
    let mut inp = String::new();

    io::stdin()
        .read_line(&mut inp)
        .expect("Failed to read line");

    let num: i64 = inp.trim().parse().expect("Input not an integer.");

    let mut ans;
    
    let mut i = 1;
    while i <= num {
        ans = num/i;    
    }  
    
    if ans == 2{
        println!("The number is prime.");
    }
        

}
