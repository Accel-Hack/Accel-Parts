import Response from "./Response";
import ResponseError from "./ResponseError";

type ResponseSetProps<E> = {
  timestamp: number

  statusCode: number
  message: string

  // 成功した時の項目
  total: number | undefined
  results: Response<E>[] | undefined

  // エラー時の項目
  errors: ResponseError[] | undefined
}

class ResponseSet<E> {
  readonly timestamp: number

  readonly statusCode: number
  readonly message: string

  // 成功した時の項目
  readonly total: number | undefined
  readonly results: Response<E>[] | undefined

  // エラー時の項目
  readonly errors: ResponseError[] | undefined

  private constructor(props: ResponseSetProps<E>) {
    this.timestamp = props.timestamp
    this.statusCode = props.statusCode
    this.message = props.message
    this.total = props.total
    this.results = props.results
    this.errors = props.errors
  }

  static decode<E>(object: any, decoder?: ((_: any) => E)): ResponseSet<E> {
    const props = {
      timestamp: object.timestamp,
      statusCode: object.statusCode,
      message: object.message,
      total: object.total,
      results: object.results?.map((_: any) => Response.decode(_, decoder)),
      errors: object.errors?.map((_: any) => ResponseError.decode(_))
    } as ResponseSetProps<E>
    return new ResponseSet(props)
  }
}

export default ResponseSet