package com.example.today.util


sealed class Either<out L, out R> {
    /** 실패의 경우를 저장 */
    data class Left<out L>(val a: L) : Either<L, Nothing>()

    /** * 성공의 경우를 저장. */
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    /**
     저장된 경우가 Right 일경우 ture 반환
     */
    val isRight get() = this is Right<R>

    /**
    저장된 경우가 LEFT 일경우 ture 반환
     */
    val isLeft get() = this is Left<L>

    /**
     left 작성
     */
    fun <L> left(a: L) = Either.Left(a)


    /**
     right 작성
     */
    fun <R> right(b: R) = Either.Right(b)

    /**
     Left 면 왼쪽 실행 Right 면 오른쪽 실행
     */
    fun fold(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Left -> fnL(a)
            is Right -> fnR(b)
        }
}


fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

/**
 Right 경우를 가정한 flatmap/map 으로서
 left 일경우 함수를 실행하지않고 Left 값을 반환합니다
 */
fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Left -> Either.Left(a)
        is Either.Right -> fn(b)
    }


fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.c(::right))


