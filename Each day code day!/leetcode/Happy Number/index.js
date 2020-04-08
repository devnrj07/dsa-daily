
//split, square , sum
const getSquaredsum = num => {num.toString()

.split('')
.map(num => parseInt(num,10) ** 2)
.reduce((acc,curr) => acc += curr,0)
}

//perform , push to stack recursively until same number is found
const isHappyNumber = (num, stack=[]) =>{
    let squaredSum = getSquaredsum(num);

    //if it ain't 1 then exit
    if(stack.includes(squaredSum)) return false;

    //if its 1 the true or push previous array as well new squared number to the current stack(array)
    return squaredSum == 1 ? true : isHappyNumber( squaredSum, [...stack,squaredSum]);
}

isHappyNumber(19);
isHappyNumber(2);