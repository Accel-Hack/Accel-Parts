export enum DayOfWeek {
  SUNDAY = 0,
  MONDAY = 1,
  TUESDAY = 2,
  WEDNESDAY = 3,
  THURSDAY = 4,
  FRIDAY = 5,
  SATURDAY = 6,
}

class CalendarUtils {
  private static HOLIDAYS = [
    // 2022年祝日
    this.date(2022, 1, 1), // 正月
    this.date(2022, 1, 10), // 成人の日
    this.date(2022, 2, 11), // 建国記念の日
    this.date(2022, 2, 23), // 天皇誕生日
    this.date(2022, 3, 21), // 春分の日
    this.date(2022, 4, 29), // 昭和の日
    this.date(2022, 5, 3), // 憲法記念日
    this.date(2022, 5, 4), // みどりの日
    this.date(2022, 5, 5), // こどもの日
    this.date(2022, 7, 18), // 海の日
    this.date(2022, 8, 11), // 山の日
    this.date(2022, 9, 19), // 敬老の日
    this.date(2022, 9, 23), // 秋分の日
    this.date(2022, 10, 10), // スポーツの日
    this.date(2022, 11, 3), // 文化の日
    this.date(2022, 11, 23), // 勤労感謝の日

    // 2023年祝日
    this.date(2023, 1, 2), // 正月
    this.date(2023, 1, 9), // 成人の日
    this.date(2023, 2, 11), // 建国記念の日
    this.date(2023, 2, 23), // 天皇誕生日
    this.date(2023, 3, 21), // 春分の日
    this.date(2023, 4, 29), // 昭和の日
    this.date(2023, 5, 3), // 憲法記念日（予定）
    this.date(2023, 5, 4), // みどりの日
    this.date(2023, 5, 5), // こどもの日
    this.date(2023, 7, 17), // 海の日
    this.date(2023, 8, 11), // 山の日
    this.date(2023, 9, 18), // 敬老の日
    this.date(2023, 9, 23), // 秋分の日
    this.date(2023, 10, 9), // スポーツの日
    this.date(2023, 11, 3), // 文化の日
    this.date(2023, 11, 23), // 勤労感謝の日
  ]

  private static date(year: number, month: number, date: number): Date {
    return new Date(year, month - 1, date)
  }

  static isSameDate(d1: Date, d2: Date): boolean {
    return this.diffDays(d1, d2) == 0
  }

  static diffDays(d1: Date, d2: Date) {
    const _MS_PER_DAY = 1000 * 60 * 60 * 24
    const utc1 = Date.UTC(d1.getFullYear(), d1.getMonth(), d1.getDate())
    const utc2 = Date.UTC(d2.getFullYear(), d2.getMonth(), d2.getDate())
    return Math.floor((utc2 - utc1) / _MS_PER_DAY);
  }

  static isHoliday(date: Date): boolean {
    return this.HOLIDAYS.some(hol =>
      this.isSameDate(hol, date))
  }

  static startOfWeek(date: Date, beginning: DayOfWeek = DayOfWeek.SUNDAY): Date {
    const day = date.getDay()
    let minus = day - beginning
    if (minus < 0) minus += 7
    return new Date(date.setDate(date.getDate() - minus))
  }

  static endOfWeek(date: Date, beginning: DayOfWeek = DayOfWeek.SUNDAY): Date {
    const startOfWeek = this.startOfWeek(date, beginning)
    return new Date(startOfWeek.setDate(startOfWeek.getDate() + 6))
  }

  static toFormat(date: Date, format: string = "YYYY-MM-DD hh:mm:ss"): string {
    return format.replace(/YYYY/g, `${date.getFullYear()}`)
      .replace(/MM/g, `0${date.getMonth() + 1}`.slice(-2))
      .replace(/M/g, `${date.getMonth() + 1}`)
      .replace(/DD/g, `0${date.getDate()}`.slice(-2))
      .replace(/D/g, `${date.getDate()}`)
      .replace(/hh/g, `0${date.getHours()}`.slice(-2))
      .replace(/mm/g, `0${date.getMinutes()}`.slice(-2))
      .replace(/ss/g, `0${date.getSeconds()}`.slice(-2))
  }
}

export default CalendarUtils