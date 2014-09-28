package models

import java.time.LocalDateTime

case class FefeBlogPost(
  permaLink: String,
  body: String,
  date: LocalDateTime,
  longestWord: String
)
