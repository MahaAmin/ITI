function charGame(text, letter){
    var n = text.length
    var res = []
    for(i=0; i<n; i++)
    {
        if(text[i] == letter)
        res.push(i)
    }

    document.write(res)
    console.log(res)
}

