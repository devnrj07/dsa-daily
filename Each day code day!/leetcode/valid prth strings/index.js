var checkValidString = function(str) {
    let countMin = 0, countMax= 0, countAst = 0;
    
    str.split('').forEach( x =>{
        if(x === '('){ countMin++; countMax++;}
        else if(x === ')'){ countMax--; countMin--;}
        else if(x === '*'){ countMax++; countMin--;}
    })

    if(countMax < 0) return false;
    countMin = Math.max(countMin,0);
    
    return countMin === 0;
};

console.log(checkValidString("(*))"))


/*

let lo = 0;
  let hi = 0;
  
  for (let char of s) {
    if (char === '(') {
      hi++;
      lo++;
      continue;
    }
    
    if (char === ')' && hi === 0) {
      return false;
    }
    
    if (char === ')') {
      hi--;
      lo = Math.max(0, lo - 1);
      continue;
    }
    
    hi++;
    lo = Math.max(0, lo - 1);
  }
  
  return lo === 0;



*/










/*

    Have two counters one counter (cmax) for counting the maximum number of right braces we can accommodate with current left braces and stars.
    Have a second counter(cmin) which represents the minimum number of right braces that must be there further to make sure the whole string is valid(this number can’t be negative, so if it becomes negative then we put it to zero.
    At any time, if cmax becomes negative, it means we can’t accommodate current right braces with current left braces and stars. So, we return false.
    In the end if cmin is positive then it means that at least there should be a cmin number of right braces to make sure the overall string is valid. So, we check whether cmin is zero or not and return the answer

*/





/* 
if(x === '(') countBraceLeft++;
        if(x === ')') countBraceRight++;
        if(x === '*') countAst++;
        
        if(countBraceLeft < 1 && countBraceRight > 0) return false;
    
    })
    console.log(arr)
    console.log('1', countBraceLeft,'r ',countBraceRight, '2', countAst);
    if(countBraceLeft ===  0 && countAst <=2 || countBraceRight === 0 && countAst <=2) return true
    if(Math.abs(countBraceLeft - countBraceRight) === countAst ) return true;
    if(s === '') return true;

    return false;*/



