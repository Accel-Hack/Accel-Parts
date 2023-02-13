class Logger {
  static debug(message?: any, ...optionalParams: any[]) {
    console.debug(message, ...optionalParams)
  }

  static info(message?: any, ...optionalParams: any[]) {
    console.info(message, ...optionalParams)
  }

  static error(message?: any, ...optionalParams: any[]) {
    console.error(message, ...optionalParams)
  }
}

export default Logger;