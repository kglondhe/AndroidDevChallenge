package com.example.androiddevchallenge

class DogRepository {
    companion object {
        fun getDogList() : List<Dog> {
            val dogs = ArrayList<Dog>()
            dogs.add(Dog("Jimmy", R.mipmap.dog1, 12))
            dogs.add(Dog("Jack", R.mipmap.dog2, 44))
            dogs.add(Dog("Genie", R.mipmap.dog3, 22))
            dogs.add(Dog("Blue", R.mipmap.dog4, 5))
            dogs.add(Dog("Blossom", R.mipmap.dog5, 11))
            dogs.add(Dog("Wow", R.mipmap.dog6, 22))
            dogs.add(Dog("Jimmy 2", R.mipmap.dog1, 12))
            dogs.add(Dog("Jack 2", R.mipmap.dog2, 44))
            dogs.add(Dog("Genie 2", R.mipmap.dog3, 22))
            dogs.add(Dog("Blue 2", R.mipmap.dog4, 5))
            dogs.add(Dog("Blossom 2", R.mipmap.dog5, 11))
            dogs.add(Dog("Wow 2", R.mipmap.dog6, 22))

            return dogs
        }
    }
}