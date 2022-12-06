import ResponseError from "./ResponseError";

type RequestProps<E> = {
  operationKey: number
  operationStatus: boolean
  result: E | undefined
  errors: ResponseError[] | undefined
}

class Request<E> {
  readonly operationKey: number
  readonly operationStatus: boolean
  readonly result: E | undefined
  readonly errors: ResponseError[] | undefined

  private constructor(props: RequestProps<E>) {
    this.operationKey = props.operationKey
    this.operationStatus = props.operationStatus
    this.errors = props.errors
    this.result = props.result
  }

  static decode<E>(object: any): Request<E> {
    const props = {
      operationKey: object.operationKey,
      operationStatus: object.operationStatus,
      result: object.result as E, // FIXME: ここでclassにdecodeしたい
      errors: object.errors,
    } as RequestProps<E>
    return new Request(props)
  }
}

export default Request