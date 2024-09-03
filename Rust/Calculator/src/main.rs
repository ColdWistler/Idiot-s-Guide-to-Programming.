fn main() {
    println!("Calculator:");
    let opt = 2;
    if opt == 1{
        addition();
    }else if opt == 2{
        subtraction();
    }else if opt == 3{
        multiplication();
    }else if opt == 4{
        division();
    }
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
