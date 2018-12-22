package com.chisw.testapplication.data.net.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Nikita R. on 22.12.2018.
 */
data class StoryModel(
    @SerializedName("exhaustiveNbHits") val exhaustiveNbHits: Boolean,
    @SerializedName("hits") val hits: List<Hit>,
    @SerializedName("hitsPerPage") val hitsPerPage: Int,
    @SerializedName("nbHits") val nbHits: Int,
    @SerializedName("nbPages") val nbPages: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("params") val params: String,
    @SerializedName("processingTimeMS") val processingTimeMS: Int,
    @SerializedName("query") val query: String
)

data class Hit(
    @SerializedName("_highlightResult") val highlightResult: HighlightResult? = null,
    @SerializedName("_tags") val tags: List<String>? = null,
    @SerializedName("author") val author: String? = null,
    @SerializedName("comment_text") val commentText: Any? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("created_at_i") val createdAtI: Int? = null,
    @SerializedName("num_comments") val numComments: Int? = null,
    @SerializedName("objectID") val objectID: String? = null,
    @SerializedName("parent_id") val parentId: Any? = null,
    @SerializedName("points") val points: Int? = null,
    @SerializedName("story_id") val storyId: Any? = null,
    @SerializedName("story_text") val storyText: Any? = null,
    @SerializedName("story_title") val storyTitle: Any? = null,
    @SerializedName("story_url") val storyUrl: Any? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("url") val url: String? = null
)

data class HighlightResult(
    @SerializedName("author") val author: Author,
    @SerializedName("title") val title: Title,
    @SerializedName("url") val url: Url
)

data class Author(
    @SerializedName("matchLevel") val matchLevel: String,
    @SerializedName("matchedWords") val matchedWords: List<Any>,
    @SerializedName("value") val value: String
)

data class Title(
    @SerializedName("matchLevel") val matchLevel: String,
    @SerializedName("matchedWords") val matchedWords: List<Any>,
    @SerializedName("value") val value: String
)

data class Url(
    @SerializedName("matchLevel") val matchLevel: String,
    @SerializedName("matchedWords") val matchedWords: List<Any>,
    @SerializedName("value") val value: String
)