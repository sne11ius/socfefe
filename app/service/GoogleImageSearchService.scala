package service

trait GoogleImageSearchService {
  def firstImageSource(searchText: String): String
}
