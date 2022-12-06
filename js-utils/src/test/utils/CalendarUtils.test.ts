import CalendarUtils, {DayOfWeek} from "../../main/utils/CalendarUtils";

describe("isSameDate", () => {
  test('(2022-09-14, 2022-09-14) => true', () => {
    expect(CalendarUtils.isSameDate(new Date(2022, 8, 14), new Date(2022, 8, 14)))
      .toBe(true)
  })

  test('(2022-09-14, 2022-09-15) => false', () => {
    expect(CalendarUtils.isSameDate(new Date(2022, 8, 14), new Date(2022, 8, 15)))
      .toBe(false)
  })
})

describe("diffDays", () => {
  test('(2022-09-14, 2022-09-14) => 0', () => {
    expect(CalendarUtils.diffDays(new Date(2022, 8, 14), new Date(2022, 8, 14)))
      .toBe(0)
  })

  test('(2020-09-14, 2019-09-14) => -366', () => {
    expect(CalendarUtils.diffDays(new Date(2020, 8, 14), new Date(2019, 8, 14)))
      .toBe(-366)
  })

  test('(2022-09-14, 2023-09-14) => 365', () => {
    expect(CalendarUtils.diffDays(new Date(2022, 8, 14), new Date(2023, 8, 14)))
      .toBe(365)
  })
})

describe("isHoliday", () => {
  test('(2023-01-09) => true(成人の日)', () => {
    expect(CalendarUtils.isHoliday(new Date(2023, 0, 9)))
      .toBe(true)
  })

  test('(2023-01-10) => false', () => {
    expect(CalendarUtils.isHoliday(new Date(2023, 0, 10)))
      .toBe(false)
  })
})

describe("startOfWeek", () => {
  test('(2022-11-29, WEDNESDAY) => "2022-11-23"', () => {
    expect(CalendarUtils.startOfWeek(new Date(2022, 10, 29), DayOfWeek.WEDNESDAY))
      .toStrictEqual(new Date(2022, 10, 23))
  })

  test('(2022-11-29, MONDAY) => "2023-11-22"', () => {
    expect(CalendarUtils.startOfWeek(new Date(2022, 10, 29), DayOfWeek.MONDAY))
      .toStrictEqual(new Date(2022, 10, 28))
  })
})

describe("endOfWeek", () => {
  test('(2022-12-30, WEDNESDAY) => "2023-01-05"', () => {
    expect(CalendarUtils.endOfWeek(new Date(2022, 11, 28), DayOfWeek.WEDNESDAY))
      .toStrictEqual(new Date(2023, 0, 3))
  })

  test('(2022-12-30, SATURDAY) => "2022-12-31"', () => {
    expect(CalendarUtils.endOfWeek(new Date(2022, 11, 28), DayOfWeek.SATURDAY))
      .toStrictEqual(new Date(2022, 11, 30))
  })
})

describe("toFormat", () => {
  test('(2023-01-01) => "2023-01-01 02:03:04"', () => {
    expect(CalendarUtils.toFormat(new Date(2023, 0, 1, 2, 3, 4)))
      .toBe("2023-01-01 02:03:04")
  })

  test('(2022-10-25) => "2022-10-25 12:23:34"', () => {
    expect(CalendarUtils.toFormat(new Date(2022, 9, 25, 12, 23, 34)))
      .toBe("2022-10-25 12:23:34")
  })

  test('(2023-1-1, "YYYY-M-D") => "2023-1-1"', () => {
    expect(CalendarUtils.toFormat(new Date(2023, 0, 1), "YYYY-M-D"))
      .toBe("2023-1-1")
  })
})
