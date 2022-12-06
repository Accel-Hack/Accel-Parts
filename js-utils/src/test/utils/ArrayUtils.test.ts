import ArrayUtils from "../../main/utils/ArrayUtils";

test('split([1,2,3,4,5,6,7,8], 3)', () => {
  expect(ArrayUtils.split([1, 2, 3, 4, 5, 6, 7, 8], 3))
    .toStrictEqual([[1, 2, 3], [4, 5, 6], [7, 8]])
})

test('split([1,2], 3)', () => {
  expect(ArrayUtils.split([1, 2], 3))
    .toStrictEqual([[1, 2]])
})
