package distributed.mall.common.utils.FastDFS;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;


/**
 * <b><code>FastDFSUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/19 20:46.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public class FastDFSClientUtil {
    private String defaultConfPath = "fdfs.cong";
    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageClient1 storageClient = null;
    private StorageServer storageServer = null;

    public FastDFSClientUtil()throws Exception{
//        String conf =this.getClass().getResource("/"+defaultConfPath).getPath();
        ClientGlobal.init("D:\\Idea_project\\distributed-mall\\distributed-mall-common\\src\\main\\resources\\fdfs.conf");
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer,storageServer);
    }
    public FastDFSClientUtil(String conf) throws Exception{
        String path = this.getClass().getResource("/"+conf).getPath();
        System.out.println(path);
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer,storageServer);

    }

    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileName 文件全路径
     * @param extName 文件扩展名，不包含（.）
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
        String result = storageClient.upload_file1(fileName, extName, metas);
        String AbsolutePath = FastDFSConstant.FILE_ADDRESS + FastDFSConstant.File_SEPARSTOR + result;
        return AbsolutePath;
    }

    public String uploadFile(String fileName, String extName) throws Exception {
        return uploadFile(fileName, extName, null);
    }

    public String uploadFile(String fileName) throws Exception {
        return uploadFile(fileName, null, null);

    }

    public String[] uploadFile(byte[] content,String extName,NameValuePair[] metaList)throws Exception{
        String[] result = storageClient.upload_file(content, extName, metaList);
        return result;
    }
    public byte[] downloadFile(String groupName,String remoteFileName)throws Exception{
        byte[] bytes = storageClient.download_file(groupName, remoteFileName);
        return bytes;
    }

    public int deleteFile(String groupName,String remoteFile) throws Exception{
        //删除成功返回0
        return storageClient.delete_file(groupName, remoteFile);
    }
    public static void main(String[] args) throws Exception {
        String conf = "fdfs.conf";
        FastDFSClientUtil fastDFSClientUtil = new FastDFSClientUtil(conf);
        String result = fastDFSClientUtil.uploadFile("C:\\Users\\Administrator\\Pictures\\fdfs.conf");
        System.out.println(result);
//        byte[] bytes = fastDFSClientUtil.downloadFile("group1", "M00/00/00/wKjRgFxDpCuAfTh_AAbGz7mvebI827.png");
//        IOUtils.write(bytes, new FileOutputStream(new File("D:/home/"+UUID.randomUUID().toString()+".png")));
//        int delete = fastDFSClientUtil.deleteFile("group1", "M00/00/00/wKjRgFxDpCuAfTh_AAbGz7mvebI827.png");
//        System.out.println(delete);
    }
}

