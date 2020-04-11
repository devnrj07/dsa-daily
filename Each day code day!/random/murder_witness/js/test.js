const findWitness = require('./index')

describe('findWitness is a function with behaviour :', () => {
    it('is a function and can be called', () => {
        expect(typeof findWitness.prototype.constructor).toBe('function')
    })

    it('return a number accepts an array', () => {
        // expect(countArrayElements([]).prototype.constructor).toBe('Array')
    })

    it('returns 0 for []', () => {
        expect(findWitness([])).toEqual(0)
    })

    it('returns 3  for heights [3, 6, 3, 4, 1]', () => {
        expect(findWitness([3, 6, 3, 4, 1])).toEqual(3)
    })


    it('returns 2  for heights [3, 4, 4, 4, 1]', () => {
        expect(findWitness([3, 4, 4, 4, 1])).toEqual(2)
    })


    it('returns 2  for heights [-1, -3, -7, -2]', () => {
        expect(findWitness([-1, -3, -7, -2])).toEqual(2)
    })
})