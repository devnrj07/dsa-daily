function minMutation(start,end,bank){

    if(start.length < 1 || end.length < 1 || bank.length < 1|| bank.indexOf(end) <0) return -1;

    let queue = []
    queue.push([start,0])
    let bankSet = new Set(bank)

    while(queue.length > 0){
        let [current_Mutation, current_level] = queue.shift();
        if(current_Mutation === end){
            return current_level;
        }

        for(let index = 0; index < current_Mutation.length; index++){
            
            ['A','C','G','T'].forEach(char =>{

            let mutation = current_Mutation.slice(0, index) + char + current_Mutation.slice(index+1) 
          
            if(bankSet.has(mutation)){
                bankSet.delete(mutation)
                queue.push([mutation, current_level+1]);
            }
        })
        }
    }
    return -1;
}