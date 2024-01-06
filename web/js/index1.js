// 切换页面
var flag = true;
function change_page(){
    var m_s = document.getElementById('myshop');
    var ml =document.getElementById('meal');
    var py = document.getElementById('pay');
    if(flag){
        ml.style.display = 'none';
        py.style.display = 'block';
        m_s.innerText = '继续任性点餐';
        flag = false;
    }else{
        ml.style.display = 'block';
        py.style.display = 'none';
        m_s.innerText = '我的购物车';
        flag = true;
    }
};
var s_n = document.getElementById('shop_num');
var mange_shop = document.getElementById('mange_shop');
var shop_pro = document.getElementById('shop_pro');
var pay_tb = document.getElementById('pay_tb');
var shop_amount = document.getElementById('shop_amount');
var pay_inf = document.getElementById('pay_inf');
var shop_pro = document.getElementById('shop_pro');
var all = document.getElementById('all');

//加入购物车
function add_shop(foodName,foodPrice){
    var pay_inf = document.getElementById('pay_inf').tBodies[0];
    //提示加入购物车成功且数量+1
    s_n.innerText= Number(s_n.innerText)+1;
    alert('成功加入购物车');
    mange_shop.style.display = 'flex';
    shop_pro.style.display = 'none';
    //判断是否有同类型菜品
    for(var i=0;i<pay_inf.rows.length;i++){
        if(pay_inf.rows[i].cells[1].innerText == foodName){ 
            pay_inf.rows[i].cells[3].innerText ++;
            return;
        }
    }
    
    //增加新菜品信息
    var tr = pay_inf.insertRow();
    tr.insertCell().innerHTML = '<input type="checkbox" onclick="select_food()">';
    tr.insertCell().innerText = foodName;
    tr.insertCell().innerText = foodPrice;
    tr.insertCell().innerText = 1;
    tr.insertCell().innerHTML = '<input type="button" value="删除" onclick="del_f(this)">';
};

//选择菜品后，计算总金额

function select_food(){
    var tr = pay_tb.rows;
    var money = 0;
    var j = 0;
    for(var i = tr.length-1;i>=0;i-- ){
        if(tr[i].cells[0].firstChild.checked){
            money += tr[i].cells[2].innerText * tr[i].cells[3].innerText;
            j++;
        }
    };
    if(j == tr.length){
        all.checked = true;
    }else{
        all.checked = false;
    }
    shop_amount.innerText = money;
};

//删除

function del_f(item){
    var tr = item.parentNode.parentNode
    console.log(tr);
    pay_inf.deleteRow(tr.rowIndex);
    s_n.innerText= Number(s_n.innerText)-tr.cells[3].innerText;
    if(s_n.innerText == 0){
        shop_pro.style.display = 'block';
        mange_shop.style.display = 'none';
    }
};


//全选
function ck_all(){
    var tr = pay_tb.rows;
    var money = 0;
    for(var i = tr.length-1;i>=0;i-- ){
        tr[i].cells[0].firstChild.checked = all.checked;
        if(tr[i].cells[0].firstChild.checked){
            money += tr[i].cells[2].innerText * tr[i].cells[3].innerText;
        }
    };
    shop_amount.innerText = money;
};

//删除选中
function del_sec(){
    var tr = pay_tb.rows;
    var i = tr.length-1;
    var money = 0
    for(;i>=0;i--){
        //判断是否选中
        if(tr[i].cells[0].firstChild.checked){
            //合计金额减去选中的菜品价格
            money = tr[i].cells[2].innerText * tr[i].cells[3].innerText;
            shop_amount.innerText -= money;
            //购物车数量减去菜品
            s_n.innerText= Number(s_n.innerText)-tr[i].cells[3].innerText;
            //删除选择的菜品
            tr[i].remove();
            if(s_n.innerText == 0){
                all.checked = false;
                shop_pro.style.display = 'block';
                mange_shop.style.display = 'none';
            }
        }
    }
};

//结算
function paymoney(){
    var pay_money= document.getElementById('shop_amount').innerText;
    if(confirm('一共支付'+pay_money+'请确认')){
        var tr = pay_tb.rows;
        var i = tr.length-1;
        for(;i>=0;i--){
            //判断是否选中
            if(tr[i].cells[0].firstChild.checked){
                //合计金额减去选中的菜品价格
                money = tr[i].cells[2].innerText * tr[i].cells[3].innerText;
                shop_amount.innerText -= money;
                //购物车数量减去菜品
                s_n.innerText= Number(s_n.innerText)-tr[i].cells[3].innerText;
                //删除选择的菜品
                tr[i].remove();
                if(s_n.innerText == 0){
                    all.checked = false;
                    shop_pro.style.display = 'block';
                    mange_shop.style.display = 'none';
                }
            }
        }
    }
};