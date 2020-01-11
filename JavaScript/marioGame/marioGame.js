function marioGame(num) {
    var i, j
    var str
    for (i = 0; i < num; i++) {
        str = ""
        for (j = 2 * (num - i); j >= 0; j--) {
            str+=" "
        }
        for(j=0; j<=i; j++){
            str+="* "
        }
        console.log(str)
    }
}