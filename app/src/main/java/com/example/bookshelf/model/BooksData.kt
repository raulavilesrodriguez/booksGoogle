package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksData(
    @SerializedName("kind") val kind: String? = null,
    @SerializedName("totalItems") val totalItems : Int? = null,
    @SerializedName("items") val items: ArrayList<Item> = arrayListOf()
    )

@Serializable
data class Item(
    @SerializedName("kind") val kind: String? = null,
    @SerializedName("id") val id : String? = null,
    @SerializedName("etag") val etag : String? = null,
    @SerializedName("selfLink") val selfLink : String? = null,
    @SerializedName("volumeInfo") var volumeInfo : VolumeInfo? = VolumeInfo(),
    @SerializedName("saleInfo") val saleInfo : SaleInfo = SaleInfo(),
    @SerializedName("accessInfo") val accessInfo : AccessInfo = AccessInfo(),
)

@Serializable
data class VolumeInfo(
    @SerializedName("title") val title: String? = null,
    @SerializedName("authors") val authors: ArrayList<String> = arrayListOf(),
    @SerializedName("publisher") val publisher: String? = null,
    @SerializedName("publishedDate") val publishedDate: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("industryIdentifiers") val industryIdentifiers: ArrayList<IndustryIdentifier> = arrayListOf(),
    @SerializedName("readingModes") val readingModes: ReadingModes? = ReadingModes(),
    @SerializedName("pageCount") val pageCount: Int? = null,
    @SerializedName("printedPageCount") val printedPageCount: Int? = null,
    @SerializedName("printType") val printType: String? = null,
    @SerializedName("categories") val categories: ArrayList<String> = arrayListOf(),
    @SerializedName("maturityRating") val maturityRating: String? = null,
    @SerializedName("allowAnonLogging") val allowAnonLogging: Boolean? = null,
    @SerializedName("contentVersion") val contentVersion: String? = null,
    @SerializedName("panelizationSummary") val panelizationSummary: PanelizationSummary? = PanelizationSummary(),
    @SerializedName("imageLinks") val imageLinks: ImageLinks? = ImageLinks(),
    @SerializedName("language") val language: String? = null,
    @SerializedName("previewLink") val previewLink: String? = null,
    @SerializedName("infoLink") val infoLink: String? = null,
    @SerializedName("canonicalVolumeLink") val canonicalVolumeLink: String? = null
)

@Serializable
data class IndustryIdentifier(
    @SerializedName("type") val type: String? = null,
    @SerializedName("identifier") val identifier: String? = null
)

@Serializable
data class ReadingModes(
    @SerializedName("text") val text: Boolean? = null,
    @SerializedName("image") val image: Boolean? = null
)

@Serializable
data class PanelizationSummary(
    @SerializedName("containsEpubBubbles") val containsEpubBubbles: Boolean? = null,
    @SerializedName("containsImageBubbles") val containsImageBubbles: Boolean? = null
)

@Serializable
data class ImageLinks(
    @SerializedName("smallThumbnail") val smallThumbnail: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null,
    @SerializedName("small") val small: String? = null,
    @SerializedName("medium") val medium: String? = null
)

@Serializable
data class SaleInfo(
    @SerializedName("country") val country : String? = null,
    @SerializedName("saleability") val saleability : String? = null,
    @SerializedName("isEbook") val isEbook : Boolean? = null
)

@Serializable
data class AccessInfo(
    @SerializedName("country") val country : String? = null,
    @SerializedName("viewability") val viewability : String? = null,
    @SerializedName("embeddable") val embeddable : Boolean? = null,
    @SerializedName("publicDomain") val publicDomain : Boolean? = null,
    @SerializedName("textToSpeechPermission") val textToSpeechPermission : String? = null,
    @SerializedName("epub") val epub : Epub = Epub(),
    @SerializedName("pdf") val pdf : Pdf = Pdf(),
    @SerializedName("ebReaderLink") val webReaderLink : String? = null,
    @SerializedName("accessViewStatus") val accessViewStatus : String? = null,
    @SerializedName("quoteSharingAllowed") val quoteSharingAllowed : Boolean? = null
)

@Serializable
data class Epub(
    @SerializedName("isAvailable") val isAvailable : Boolean? = null,
    @SerializedName("acsTokenLink") val acsTokenLink : String? = null
)

@Serializable
data class Pdf(
    @SerializedName("isAvailable") val isAvailable : Boolean? = null,
    @SerializedName("acsTokenLink") val acsTokenLink : String? = null
)

@Serializable
data class SearchInfo(
    @SerializedName("textSnippet") val textSnippet : String? = null
)



