package com.example.my_vk_client.data.repo

import com.example.my_vk_client.converter.DataConverter
import com.example.my_vk_client.data.repo.source.PostDataSource
import com.example.my_vk_client.domain.repo.PostRepository
import com.example.my_vk_client.domain.repo.entity.Post
import com.example.my_vk_client.response.PostResponse
import io.reactivex.schedulers.Schedulers
import io.reactivex.Single
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource,
    private val postsConverter: DataConverter<PostResponse, List<Post>>
) : PostRepository {
    override fun getPosts(page: Int): Single<List<Post>> =
        postDataSource.getPosts(132089045, page)
            .subscribeOn(Schedulers.io())
            .map(postsConverter::convert)
}