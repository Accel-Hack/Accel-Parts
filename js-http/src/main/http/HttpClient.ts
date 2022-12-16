import ResponseSet from "./entity/ResponseSet";

class HttpClient {
  private static defaultConfig = {
    mode: "cors", // no-cors, *cors, same-origin
    cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
    credentials: "same-origin", // include, *same-origin, omit
    headers: {
      "Content-Type": "application/json"
    },
    redirect: "follow", // manual, *follow, error
    referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
  }

  static get<E>(url: string, decoder?: ((_: any) => E), option: object = {}): Promise<ResponseSet<E> | any> {
    const getOption = {...this.defaultConfig, ...option, method: "GET"}
    return this.fetch<E>(url, getOption)
  }

  static post<E>(url: string, body: any, decoder?: ((_: any) => E), option: object = {}): Promise<ResponseSet<E> | any> {
    const postOption = {...this.defaultConfig, ...option, body: JSON.stringify(body), method: "POST"}
    return this.fetch<E>(url, postOption, decoder)
  }

  static fetch<E>(url: string, option: object, decoder?: ((_: any) => E)): Promise<ResponseSet<E> | any> {
    return new Promise((resolve, reject) => {
      fetch(url, option)
        .then(response => response.json())
        .then(json => resolve(ResponseSet.decode<E>(json, decoder)))
        .catch(error => reject(error))
    })
  }
}

export default HttpClient