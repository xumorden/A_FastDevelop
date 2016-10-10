package com.xumaodun.a_fastdeveop.retrofit;

import java.util.List;

/**
 * Created by xumaodun on 16/6/13.
 */
public class MovieBean {

    /**
     * ack : true
     * version : 1.0
     * copyright : @2014 上海思蓄力教育科技有限公司
     * timestamp : 1465799576437
     * code : 200
     * data : [{"eid":"5694bddf0cf2e7514bf60678","name":"耶鲁大学","enName":"Yale University","sort":100,"icon":"images/14580376010004cdd0cd3-c892-4ef0-bd7e-17ba097a4e26.jpg","background":"images/145709638600083e123dd-3afd-449e-a417-175320639fb0.jpg"},{"eid":"5694bc490cf2e7514bf60672","name":"哈佛大学","enName":"Harvard University","sort":99,"icon":"images/1457431335000ba3f4127-29d1-4bf5-a7b9-4769e65c5743.png","background":"images/1457099082000f0a7b64a-2889-48fd-9d18-5a04cd835dc1.jpg"},{"eid":"5694bdf10cf2e7514bf60679","name":"哥伦比亚大学","enName":"Columbia University","sort":98,"icon":"images/14574316240004c1bf9d2-93ef-4010-84ad-ade2dfad56a7.jpg","background":"images/145709839100012316c56-5d82-402d-b27d-356f2e858f64.jpg"},{"eid":"5694be480cf2e7514bf6067e","name":"宾夕法尼亚大学","enName":"University of Pennsylvania","sort":96,"icon":"images/145743170100083ab8c7c-8ba9-4d37-8812-107e0f5a7a5b.png","background":"images/1457098695000d04d3150-f279-430b-9147-ac7e6bb8179a.jpg"},{"eid":"5694d29a0cf2daceefc4913a","name":"布朗大学","enName":"Brown University","sort":95,"icon":"images/1457096450000292eea16-c1f3-45b8-95ea-2aa71bd06f36.png","background":"images/145709891600006abb120-8273-447d-959c-09d5badfd242.jpg"},{"eid":"5694be2b0cf2e7514bf6067c","name":"斯坦福大学","enName":"Stanford University","sort":94,"icon":"images/14574318470009384d2a7-e161-4b62-80b5-db30cf225867.png","background":"images/1457099481000db31a39f-7984-48be-b50b-6c142aef6c68.jpg"},{"eid":"5694be060cf2e7514bf6067a","name":"芝加哥大学","enName":"University of Chicago","sort":93,"icon":"images/14574319920009067be95-5229-415b-9ebb-d016ba354826.png","background":"images/145709774600026a33ace-1269-437f-82c0-f484509fd0f8.jpg"},{"eid":"5694be3a0cf2e7514bf6067d","name":"杜克大学","enName":"Duke University","sort":92,"icon":"images/1457432069000347036b0-af53-43b2-b44b-46b553c93f1f.jpeg","background":"images/145709810300035c650fa-2e19-46b1-b2b2-34bf93290ac6.jpg"},{"eid":"5694be660cf2e7514bf60681","name":"西北大学","enName":"Northwestern University","sort":91,"icon":"images/14570997760004804b313-0aaf-43dd-84a0-98251613fcd7.jpg","background":"images/14571002520002e8c95a8-8b3e-49f5-a68b-701f8b088924.jpg"},{"eid":"5694c0170cf2c963608f77be","name":"波莫纳学院","enName":"Pomona College","sort":90,"icon":"images/14580388930009d81fc1b-6acb-4894-99db-e9ae86998159.jpg","background":"images/14571005950001f1493f9-79af-4e99-9724-6713e3db976a.jpg"},{"eid":"5694be570cf2e7514bf60680","name":"达特茅斯学院","enName":"Dartmouth College","sort":89,"icon":"images/1457432278000891cec36-b94a-4666-96b5-64ed92991239.png","background":"images/145710084000095196149-329d-43e2-96e5-57f6e2d47815.jpg"},{"eid":"5694bea50cf2e7514bf60684","name":"康奈尔大学","enName":"Cornell University","sort":88,"icon":"images/145743236800021ba21ce-e3ed-4d05-8aea-bf3969d94058.jpg","background":"images/1457102245000a8d0a06d-efca-4328-bb42-5da3b743beba.jpg"},{"eid":"5694be750cf2e7514bf60682","name":"约翰霍普金斯大学","enName":"Johns Hopkins University","sort":87,"icon":"images/14571026900006dfef145-2118-4a13-9c75-f2e09c387021.jpg","background":"images/14571028270005045b7e6-63ee-45c3-80e2-c5e3fad41dc1.jpg"},{"eid":"5694bf270cf2e7514bf60689","name":"加州大学伯克利分校","enName":"University of California-Berkeley","sort":86,"icon":"images/1457432564000ce56a6e9-201c-44f6-9c56-e5bb364b077e.png","background":"images/1457103713000470439b3-bc80-4fd0-93b3-e98d95fbc2b3.jpg"},{"eid":"5694bef20cf2e7514bf60688","name":"弗吉尼亚大学","enName":"University of Virginia","sort":84,"icon":"images/145743262500058cf9857-23f7-4ea7-9ff3-446c1e8c8d4f.jpg","background":"images/1457104211000de95363b-b30c-4366-8ce2-155e4d5c4e28.jpg"},{"eid":"5694bf3b0cf2e7514bf6068a","name":"纽约大学","enName":"New York University","sort":83,"icon":"images/1457097111000cf4cbd31-b3f0-4af1-bb1d-16ec19045cf9.jpg","background":"images/145709721100084504093-0886-4da0-99ea-764056c2b0c7.jpg"},{"eid":"5694bdcb0cf2e7514bf60677","name":"普林斯顿大学","enName":"Princeton University","sort":83,"icon":"images/145803852800010682efc-cf0f-460f-9021-8a67a832fcac.jpg","background":"images/1457104507000a5083915-203d-4b21-a20b-32e67edc02ab.jpg"},{"eid":"5694be890cf2e7514bf60683","name":"华盛顿圣路易斯大学","enName":"Washington University in St. Louis","sort":82,"icon":"images/145743283800056240f1f-710a-497e-a556-32af0c3fa490.png","background":"images/1457104748000a1ccbe74-e3e8-4742-9654-b509ab01d29a.jpg"},{"eid":"5694c0360cf2c963608f77bf","name":"哈弗福德学院","enName":"Haverford College","sort":81,"icon":"images/1457105331000fe8037cc-3faa-47a0-a08d-652c11ba4fd9.jpg","background":"images/1457105357000511da1a9-2fee-46e9-bec5-eeaece617e67.jpg"},{"eid":"5694c07d0cf2c963608f77c1","name":"牛津大学","enName":"University of Oxford","sort":80,"icon":"images/14571055730006b068741-3069-4f68-a72d-cc2a554279cd.jpg","background":"images/145710561300080b0f331-1234-42bf-866b-c92e22e6cb3e.jpg"},{"eid":"5694c0600cf2c963608f77c0","name":"罗切斯特大学","enName":"University of Rochester","sort":79,"icon":"images/14575195570006a5325c3-e35f-4d75-82b4-c2c5b1b3b2f6.png","background":"images/145710591400093a8e0e8-590b-4c0f-b337-f08686621247.jpg"},{"eid":"569e08f90cf204ca1e4e595e","name":"莱斯大学","enName":"Rice University","sort":78,"icon":"images/145743318000094c58853-5362-42d3-95a4-73b11d887d8c.jpg","background":"images/1457106310000ed3c67cb-027d-4004-8dff-704375a936f2.jpg"},{"eid":"56d94e760cf29c04b3766f2b","name":"Jet Learn","enName":"Jet Learn","sort":0,"icon":"images/1457519280000c48ed342-b947-4619-a99f-9011dc108470.png","background":"images/145711290100082990ac3-1127-47c4-8fbc-66e42b7d6d3e.jpg"},{"eid":"5694beba0cf2e7514bf60685","name":"圣母大学","enName":"University of Notre Dame","sort":0,"icon":"images/145743340000059286322-d081-4309-a794-5a070bef4eda.jpg","background":"images/145711105500008d7cf4f-5bca-428a-95e6-f9500b4180f8.jpg"},{"eid":"56a0a1d80cf204fd74526c67","name":"罗德岛设计学院","enName":"Rhode Island School of Design","sort":0,"icon":"images/1457433480000c1d661c0-8e46-4c50-8112-d8e521606140.jpg","background":"images/1457111849000e7ae77f5-e0ec-42e3-a4ce-a58d80ff5651.jpg"},{"eid":"5694bee50cf2e7514bf60687","name":"卡内基梅隆大学","enName":"Carnegie Mellon University","sort":0,"icon":"images/145804254100049ca4791-1784-4d13-a38a-53eaf2f17403.jpg","background":"images/1457107745000b1611355-ac19-4483-b7ec-08335d7a1137.jpg"},{"eid":"5694bed70cf2e7514bf60686","name":"乔治城大学","enName":"Georgetown University","sort":0,"icon":"images/14580421900009b41bd05-b86e-48f4-8757-ae0e43d36547.jpg","background":"images/1457108208000e9f76269-95c0-4277-b2b6-74829c42c417.jpg"},{"eid":"56b161670cf27666c91da9ca","name":"埃默里大学","enName":"Emory University","sort":0,"icon":"images/1457433692000afb828f7-b488-4633-bac4-e459f9151650.png","background":"images/145710923300013879021-f7b0-4e94-807f-47b9a6d38f14.jpg"},{"eid":"5694bf8c0cf2c963608f77bc","name":"科尔盖特大学","enName":"Colgate University","sort":0,"icon":"images/1457433749000d7de53e4-0c67-424c-8d27-12d3b6bb08bc.jpg","background":"images/14571100480009c4feb71-47b4-401f-b2a0-c64e4410e770.jpg"},{"eid":"5694c00a0cf2c963608f77bd","name":"南加州大学","enName":"University of Southern California","sort":0,"icon":"images/145743384100058d2f605-8394-431d-b06b-2a1817b39bdb.png","background":"images/1457111201000f0e220e6-7300-4a2f-9d0c-58ab1023db12.jpg"},{"eid":"56deaeea0cf296dc161180e4","name":"加利福尼亚大学洛杉矶分校","enName":"University of California, Los Angeles","sort":0,"icon":"images/1457434054000e823c207-1200-4fb0-a20d-f314c7600f9e.jpg","background":"images/1457434335000a2401dd3-e229-4641-9246-9483b6c117a2.png"},{"eid":"5694bf460cf2e7514bf6068b","name":"瓦萨学院","enName":"Vassar College","sort":0,"icon":"images/145743082500046f3aa37-476f-4025-b4fa-9c4887816d9f.jpg","background":"images/14571074150000bbff9c3-b96e-4046-bb06-d16af60526a1.jpg"}]
     * totalItems : 0
     */

    private boolean ack;
    private String version;
    private String copyright;
    private long timestamp;
    private int code;
    private int totalItems;
    /**
     * eid : 5694bddf0cf2e7514bf60678
     * name : 耶鲁大学
     * enName : Yale University
     * sort : 100
     * icon : images/14580376010004cdd0cd3-c892-4ef0-bd7e-17ba097a4e26.jpg
     * background : images/145709638600083e123dd-3afd-449e-a417-175320639fb0.jpg
     */

    private List<DataBean> data;

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String eid;
        private String name;
        private String enName;
        private int sort;
        private String icon;
        private String background;

        public String getEid() {
            return eid;
        }

        public void setEid(String eid) {
            this.eid = eid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }

    @Override
    public String toString() {
        return "MovieBean{" +
                "ack=" + ack +
                ", version='" + version + '\'' +
                ", copyright='" + copyright + '\'' +
                ", timestamp=" + timestamp +
                ", code=" + code +
                ", totalItems=" + totalItems +
                ", data=" + data +
                '}';
    }
}
