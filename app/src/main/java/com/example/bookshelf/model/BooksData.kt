package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksData(
    @SerializedName("kind"       ) val kind       : String?          = null,
    @SerializedName("totalItems" ) val totalItems : Int?             = null,
    @SerializedName("items") val items: ArrayList<Book> = arrayListOf()
    )

@Serializable
data class Book(
    val kind: String,
    val id : String,
    @SerialName("etaq") val eTag : String? = null,
    val selfLink : String,
    val volumeInfo : VolumeInfo,
    val saleInfo : SaleInfo,
    val accessInfo : AccessInfo,
    val searchInfo : SearchInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String> = emptyList(),
    val publisher: String? = null,
    val publishedDate: String? = null,
    val description: String? = null,
    val industryIdentifiers: List<IndustryIdentifier> = emptyList(),
    val readingModes: ReadingModes? = null,
    val pageCount: Int? = null,
    val printedPageCount: Int? = null,
    val printType: String? = null,
    val categories: List<String> = emptyList(),
    val maturityRating: String? = null,
    val allowAnonLogging: Boolean? = null,
    val contentVersion: String? = null,
    val panelizationSummary: PanelizationSummary? = null,
    val imageLinks: ImageLinks? = null,
    val language: String? = null,
    val previewLink: String? = null,
    val infoLink: String? = null,
    val canonicalVolumeLink: String? = null
)

@Serializable
data class IndustryIdentifier(
    val type: String,
    val identifier: String
)

@Serializable
data class ReadingModes(
    val text: Boolean,
    val image: Boolean
)

@Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String? = null,
    val thumbnail: String? = null,
    val small: String? = null,
    val medium: String? = null
)

@Serializable
data class SaleInfo(
    val country : String? = null,
    val saleability : String? = null,
    val isEbook : Boolean
)

@Serializable
data class AccessInfo(
    val country : String,
    val viewability : String,
    val embeddable : Boolean,
    val publicDomain : Boolean,
    val textToSpeechPermission : String,
    val epub : Epub,
    val pdf : Pdf,
    val webReaderLink : String? = null,
    val accessViewStatus : String? = null,
    val quoteSharingAllowed : Boolean
)

@Serializable
data class Epub(
    val isAvailable : Boolean,
    val acsTokenLink : String? = null
)

@Serializable
data class Pdf(
    val isAvailable : Boolean,
    val acsTokenLink : String? = null
)

@Serializable
data class SearchInfo(
    val textSnippet : String? = null
)



