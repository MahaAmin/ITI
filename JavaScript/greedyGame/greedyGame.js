function greedyGame(num){
    var dollar, quarter, dime, nickel, cent
    dollar = parseInt(num)
    num -= dollar
    num *= 100
    quarter = parseInt(num/25)
    num -= quarter*25   
    dime = parseInt(num/10)
    num -= dime*10
    nickel = parseInt(num/5)
    num -= nickel*5
    cent = num

    console.log("You have "+dollar+" dolars, "+quarter+" quarters, "+dime+" dimes, "+nickel+" nickels, and "+cent+" cents.")
    

}