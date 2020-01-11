function fizzBuzz(num) {
    if (num % 3 == 0 && num % 5 == 0) {
        console.log("Fizz Buzz")
        document.write("Fizz Buzz")
    }
    else if (num % 3 == 0) {
        console.log("Fizz")
        document.write("Fizz")
    }

    else if (num % 5 == 0) {
        console.log("Buzz")
        document.write("Buzz")
    }

    else {
        console.log("None")
        document.write("None")

    }
}


var x = prompt("Enter a number for FizzBuzz")
fizzBuzz(x)