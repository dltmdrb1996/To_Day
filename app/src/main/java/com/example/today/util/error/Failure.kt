
package com.example.today.util.error


sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()

}
