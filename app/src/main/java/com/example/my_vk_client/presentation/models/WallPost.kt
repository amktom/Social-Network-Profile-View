package com.example.my_vk_client.presentation.models

class WallPost (
        id: Int,
        val message: String,
        val postContent: List<PostContent>
) : WallItem(id)