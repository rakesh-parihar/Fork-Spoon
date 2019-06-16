package com.fns.recipe.api.model


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("includes")
    val includes: Includes = Includes(),
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("skip")
    val skip: Int = 0,
    @SerializedName("sys")
    val sys: Sys = Sys(),
    @SerializedName("total")
    val total: Int = 0
) {
    data class Item(
        @SerializedName("fields")
        val fields: Fields = Fields(),
        @SerializedName("sys")
        val sys: Sys = Sys()
    ) {
        data class Fields(
            @SerializedName("calories")
            val calories: Int = 0,
            @SerializedName("chef")
            val chef: Chef = Chef(),
            @SerializedName("description")
            val description: String = "",
            @SerializedName("photo")
            val photo: Photo = Photo(),
            @SerializedName("tags")
            val tags: List<Fields.Tag> = listOf(),
            @SerializedName("title")
            val title: String = ""
        ) {
            data class Photo(
                @SerializedName("sys")
                val sys: Sys = Sys()
            ) {
                data class Sys(
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("linkType")
                    val linkType: String = "",
                    @SerializedName("type")
                    val type: String = ""
                )
            }

            data class Chef(
                @SerializedName("sys")
                val sys: Sys = Sys()
            ) {
                data class Sys(
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("linkType")
                    val linkType: String = "",
                    @SerializedName("type")
                    val type: String = ""
                )
            }

            data class Tag(
                @SerializedName("sys")
                val sys: Sys = Sys()
            ) {
                data class Sys(
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("linkType")
                    val linkType: String = "",
                    @SerializedName("type")
                    val type: String = ""
                )
            }
        }

        data class Sys(
            @SerializedName("contentType")
            val contentType: ContentType = ContentType(),
            @SerializedName("createdAt")
            val createdAt: String = "",
            @SerializedName("environment")
            val environment: Environment = Environment(),
            @SerializedName("id")
            val id: String = "",
            @SerializedName("locale")
            val locale: String = "",
            @SerializedName("revision")
            val revision: Int = 0,
            @SerializedName("space")
            val space: Space = Space(),
            @SerializedName("type")
            val type: String = "",
            @SerializedName("updatedAt")
            val updatedAt: String = ""
        ) {
            data class Space(
                @SerializedName("sys")
                val sys: Sys = Sys()
            ) {
                data class Sys(
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("linkType")
                    val linkType: String = "",
                    @SerializedName("type")
                    val type: String = ""
                )
            }

            data class Environment(
                @SerializedName("sys")
                val sys: Sys = Sys()
            ) {
                data class Sys(
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("linkType")
                    val linkType: String = "",
                    @SerializedName("type")
                    val type: String = ""
                )
            }

            data class ContentType(
                @SerializedName("sys")
                val sys: Sys = Sys()
            ) {
                data class Sys(
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("linkType")
                    val linkType: String = "",
                    @SerializedName("type")
                    val type: String = ""
                )
            }
        }
    }

    data class Sys(
        @SerializedName("type")
        val type: String = ""
    )

    data class Includes(
        @SerializedName("Asset")
        val asset: List<Asset> = listOf(),
        @SerializedName("Entry")
        val entry: List<Entry> = listOf()
    ) {
        data class Entry(
            @SerializedName("fields")
            val fields: Fields = Fields(),
            @SerializedName("sys")
            val sys: Sys = Sys()
        ) {
            data class Fields(
                @SerializedName("name")
                val name: String = ""
            )

            data class Sys(
                @SerializedName("contentType")
                val contentType: ContentType = ContentType(),
                @SerializedName("createdAt")
                val createdAt: String = "",
                @SerializedName("environment")
                val environment: Environment = Environment(),
                @SerializedName("id")
                val id: String = "",
                @SerializedName("locale")
                val locale: String = "",
                @SerializedName("revision")
                val revision: Int = 0,
                @SerializedName("space")
                val space: Space = Space(),
                @SerializedName("type")
                val type: String = "",
                @SerializedName("updatedAt")
                val updatedAt: String = ""
            ) {
                data class Space(
                    @SerializedName("sys")
                    val sys: Sys = Sys()
                ) {
                    data class Sys(
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("linkType")
                        val linkType: String = "",
                        @SerializedName("type")
                        val type: String = ""
                    )
                }

                data class Environment(
                    @SerializedName("sys")
                    val sys: Sys = Sys()
                ) {
                    data class Sys(
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("linkType")
                        val linkType: String = "",
                        @SerializedName("type")
                        val type: String = ""
                    )
                }

                data class ContentType(
                    @SerializedName("sys")
                    val sys: Sys = Sys()
                ) {
                    data class Sys(
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("linkType")
                        val linkType: String = "",
                        @SerializedName("type")
                        val type: String = ""
                    )
                }
            }
        }

        data class Asset(
            @SerializedName("fields")
            val fields: Fields = Fields(),
            @SerializedName("sys")
            val sys: Sys = Sys()
        ) {
            data class Sys(
                @SerializedName("createdAt")
                val createdAt: String = "",
                @SerializedName("environment")
                val environment: Environment = Environment(),
                @SerializedName("id")
                val id: String = "",
                @SerializedName("locale")
                val locale: String = "",
                @SerializedName("revision")
                val revision: Int = 0,
                @SerializedName("space")
                val space: Space = Space(),
                @SerializedName("type")
                val type: String = "",
                @SerializedName("updatedAt")
                val updatedAt: String = ""
            ) {
                data class Space(
                    @SerializedName("sys")
                    val sys: Sys = Sys()
                ) {
                    data class Sys(
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("linkType")
                        val linkType: String = "",
                        @SerializedName("type")
                        val type: String = ""
                    )
                }

                data class Environment(
                    @SerializedName("sys")
                    val sys: Sys = Sys()
                ) {
                    data class Sys(
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("linkType")
                        val linkType: String = "",
                        @SerializedName("type")
                        val type: String = ""
                    )
                }
            }

            data class Fields(
                @SerializedName("file")
                val `file`: File = File(),
                @SerializedName("title")
                val title: String = ""
            ) {
                data class File(
                    @SerializedName("contentType")
                    val contentType: String = "",
                    @SerializedName("details")
                    val details: Details = Details(),
                    @SerializedName("fileName")
                    val fileName: String = "",
                    @SerializedName("url")
                    val url: String = ""
                ) {
                    data class Details(
                        @SerializedName("image")
                        val image: Image = Image(),
                        @SerializedName("size")
                        val size: Int = 0
                    ) {
                        data class Image(
                            @SerializedName("height")
                            val height: Int = 0,
                            @SerializedName("width")
                            val width: Int = 0
                        )
                    }
                }
            }
        }
    }
}