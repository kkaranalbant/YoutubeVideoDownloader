from pytubefix import YouTube
import sys

def download_video (url , path) :
    yt = YouTube(url)

    video = yt.streams.get_lowest_resolution()

    file_name = video.download(path)

    print (file_name)

if __name__ == "__main__":
    url = sys.argv[1]
    path = sys.argv[2]
    download_video(url, path)
