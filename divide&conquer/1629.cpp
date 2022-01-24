#include<iostream>
using namespace std;
typedef long long ll;

ll binpow(ll a, ll b, ll c) {
	if (b == 1) { return a % c; }
	ll temp = binpow(a, b / 2, c);
	if (b % 2 == 0) { return temp * temp % c; }
	else { return temp * temp % c * a % c; }
}

int main() {
	ll a, b, c;
	cin >> a >> b >> c;

	cout << binpow(a, b, c) << endl;
}

//https://guccin.tistory.com/117 ¸¦ Âü°í