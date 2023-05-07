type ReturnObj = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): ReturnObj {
        
    let numberr =init;
    return{
         increment : function() {
       numberr += 1;
       return numberr;
    },
         decrement: function() {
       numberr -= 1;
       return numberr;
    }
     ,    reset: function() {
       numberr = init;
       return numberr;
    },
}
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */