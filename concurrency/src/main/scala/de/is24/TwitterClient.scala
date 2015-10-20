package de.is24

import scala.concurrent.Future

object TwitterClient {

  def getTweetsForUser(userName: String): Future[Seq[Tweet]] = {
    userName match {
      case "mriehl" =>
        Future.successful(
          Seq(
            Tweet(text= "Haun!!!!!!!"),
            Tweet(text= "Das waere mit git nicht passiert."),
            Tweet(text= "Oh Gott die legacy App!")
          )
        )
      case "phaun" =>
        Future.successful(
          Seq(
            Tweet(text= "Riehl!!!!!!!"),
            Tweet(text= "I can neither confirm nor deny any S.H.I.E.L.D. operation.")
          )
        )
      case _ =>
        Future.failed(new RuntimeException("unknown user"))
    }
  }

}
